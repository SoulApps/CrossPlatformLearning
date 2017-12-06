<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Incidencia extends CI_Controller {

     public function getAll() {
        $this->load->database();

		if (isset($_GET["codProf"]) && isset($_GET["token"])) {
				$query = $this->db->query("SELECT * FROM profesor WHERE codProf = {$this->db->escape_str($_GET['codProf'])} AND token = '{$this->db->escape_str($_GET["token"])}'");
				if ($query->num_rows() > 0) {
					//Se necesita el parámetro 'solucionado' para funcionar.

					//Se pasa a boolean.
					$solucionado = filter_var($_GET['solucionado'], FILTER_VALIDATE_BOOLEAN);
					$antiguos = filter_var($_GET['antiguos'], FILTER_VALIDATE_BOOLEAN)?"ASC":"DESC";

					if ($solucionado == true) {
						$query = $this->db->query("SELECT i.codIncidencia, i.codProf, i.codMaterial, DATE_FORMAT(i.fecha, '%Y-%m-%d %H:%i') fecha, i.descripcion, i.historial, i.estado, p.nombre, p.apellido1, m.planta, m.codAula 
													FROM incidencia i JOIN material m ON i.codMaterial = m.codMaterial 
													JOIN profesor p ON p.codProf = i.codProf ORDER BY i.fecha {$antiguos}");
					} else {
						$query = $this->db->query("SELECT i.codIncidencia, i.codProf, i.codMaterial, DATE_FORMAT(i.fecha,'%Y-%m-%d %H:%i') fecha, i.descripcion, i.historial, i.estado, p.nombre, p.apellido1, m.planta, m.codAula 
													FROM incidencia i JOIN material m ON i.codMaterial = m.codMaterial 
													JOIN profesor p ON p.codProf = i.codProf 
													WHERE i.estado != 'SOLUCIONADO' ORDER BY i.fecha {$antiguos}");
					}
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
				
				$this->db->query("INSERT INTO incidencia(codProf, codMaterial, fecha, descripcion) VALUES({$this->db->escape_str($obj["codProf"])}, {$this->db->escape_str($obj["codMaterial"])}, '{$this->db->escape_str($obj["fecha"])}', '{$this->db->escape_str($obj["descripcion"])}')");
			}
		}

		$this->db->close();
	}

	public function put($codIncidencia) {
		$this->load->database();

		if (isset($_GET["codProf"]) && isset($_GET["token"])) {
			$query = $this->db->query("SELECT * FROM profesor WHERE codProf = {$this->db->escape_str($_GET['codProf'])} AND token = '{$this->db->escape_str($_GET["token"])}'");
			if ($query->num_rows() > 0) {
				$json = file_get_contents('php://input');
				$obj = json_decode($json, true);
				
				$this->db->query("UPDATE incidencia SET historial = '{$this->db->escape_str($obj["historial"])}', estado = '{$this->db->escape_str($obj["estado"])}' WHERE codIncidencia = '{$codIncidencia}'");
			}
		}
		
		$this->db->close();
	}
}
