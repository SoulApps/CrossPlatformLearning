<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Material extends CI_Controller {

	public function getAllByAula($planta, $codAula) {
        $this->load->database();
		
		if (isset($_GET["codProf"]) && isset($_GET["token"])) {
			$query = $this->db->query("SELECT * FROM profesor WHERE codProf = {$this->db->escape_str($_GET['codProf'])} AND token = '{$this->db->escape_str($_GET["token"])}'");
			if ($query->num_rows() > 0) {
				$query = $this->db->query("SELECT * FROM material WHERE planta = {$this->db->escape_str($planta)} AND codAula = {$this->db->escape_str($codAula)} ORDER BY planta, codAula, codMaterial");
				echo json_encode($query->result(), JSON_NUMERIC_CHECK);
			}
		}

		$this->db->close();
    }

    public function getAllByHardware($codBarras) {
        $this->load->database();

		if (isset($_GET["codProf"]) && isset($_GET["token"])) {
			$query = $this->db->query("SELECT * FROM profesor WHERE codProf = {$this->db->escape_str($_GET['codProf'])} AND token = '{$this->db->escape_str($_GET["token"])}'");
			if ($query->num_rows() > 0) {
				$query = $this->db->query("SELECT m.*, a.nombre FROM material m JOIN aula a ON m.planta = a.planta AND m.codAula = a.codAula WHERE m.codBarras = '{$this->db->escape_str($codBarras)}' ORDER BY a.planta, a.codAula, m.codMaterial");
				echo json_encode($query->result(), JSON_NUMERIC_CHECK);
			}
		}

		$this->db->close();
    }

	public function post() {
		$this->load->database();

		if (isset($_GET["codProf"]) && isset($_GET["token"])) {
			$query = $this->db->query("SELECT * FROM profesor WHERE codProf = {$this->db->escape_str($_GET['codProf'])} AND token = '{$this->db->escape_str($_GET["token"])}'");
			if ($query->num_rows() > 0) {
				$json = file_get_contents('php://input');
				$obj = json_decode($json, true);

				$codBarras = $this->db->escape_str($obj["codBarras"]);
				$codMaterial = $this->db->escape_str($obj["codMaterial"]);

				$query = $this->db->query("SELECT unidadesEnUso, unidadesTotales FROM hardware WHERE codBarras = '{$codBarras}'");
				$row = $query->row();
				if (isset($row)) {
					$unidadesEnUso = $row->unidadesEnUso;
					$unidadesTotales = $row->unidadesTotales;

					//Devuelve 0 si se ha insertado con exito y 1 si la clave está repetida y 2 si no hay unidades disponibles.
					if ($unidadesEnUso < $unidadesTotales) {
						$query = $this->db->query("SELECT COUNT(*) count FROM material WHERE codMaterial = {$codMaterial}");
						$row = $query->row();
						if (isset($row)) {
							$count = $row->count;
							
							if ($count == 0) {
								$this->db->query("INSERT INTO material VALUES({$this->db->escape_str($obj["codMaterial"])}, '{$this->db->escape_str($obj["codBarras"])}', {$this->db->escape_str($obj["planta"])}, '{$this->db->escape_str($obj["codAula"])}')");
								$this->db->query("UPDATE hardware SET unidadesEnUso = unidadesEnUso + 1 WHERE codBarras = '{$this->db->escape_str($codBarras)}'");
								echo "0";
							} else {
								echo "1";
							}
						}
					} else {
						echo "2";
					}
				}
			}
		}

		$this->db->close();
	}

	public function delete($codMaterial) {
		$this->load->database();

		if (isset($_GET["codProf"]) && isset($_GET["token"])) {
			$query = $this->db->query("SELECT * FROM profesor WHERE codProf = {$this->db->escape_str($_GET['codProf'])} AND token = '{$this->db->escape_str($_GET["token"])}'");
			if ($query->num_rows() > 0) {
				$query = $this->db->query("SELECT codBarras FROM material WHERE codMaterial = '{$this->db->escape_str($codMaterial)}'");
				$row = $query->row();
				if (isset($row)) {
					$codBarras = $row->codBarras;

					$this->db->query("DELETE FROM material WHERE codMaterial = {$this->db->escape_str($codMaterial)}");
					$this->db->query("UPDATE hardware SET unidadesEnUso = unidadesEnUso - 1 WHERE codBarras = '{$codBarras}'");

					//Se borran también las inicidencias.
					$this->db->query("DELETE FROM incidencia WHERE codMaterial = {$this->db->escape_str($codMaterial)}");
				}
			}
		}

		$this->db->close();
	}
}
