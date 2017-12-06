<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Reserva extends CI_Controller {

	public function getDay($planta, $codAula, $fecha) {
		$this->load->database();

		if (isset($_GET["codProf"]) && isset($_GET["token"])) {
			$query = $this->db->query("SELECT * FROM profesor WHERE codProf = {$this->db->escape_str($_GET['codProf'])} AND token = '{$this->db->escape_str($_GET["token"])}'");
			if ($query->num_rows() > 0) {
				$query = $this->db->query("SELECT r.codProf, TIME_FORMAT(t.horaInicio, '%H:%i') horaInicio, TIME_FORMAT(t.horaFin, '%H:%i') horaFin, p.nombre, p.apellido1 
					FROM tramohorario t LEFT JOIN reserva r ON t.codTramo = r.codTramo 
					AND r.planta = {$this->db->escape_str($planta)} AND r.codAula = '{$this->db->escape_str($codAula)}' AND fecha = '{$this->db->escape_str($fecha)}' 
					LEFT JOIN profesor p ON r.codProf = p.codProf");
			
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

							//Comprueba clave duplicada.
							$query = $this->db->query("SELECT r.codProf, TIME_FORMAT(t.horaInicio, '%H:%i') horaInicio, TIME_FORMAT(t.horaFin, '%H:%i') horaFin, p.nombre, p.apellido1 
								FROM tramohorario t JOIN reserva r ON t.codTramo = r.codTramo 
								AND r.planta = {$this->db->escape_str($_POST['planta'])} AND r.codAula = '{$this->db->escape_str($_POST['codAula'])}' AND fecha = '{$this->db->escape_str($_POST["fecha"])}' 
								AND r.codTramo = {$this->db->escape_str($_POST['codTramo'])} 
								JOIN profesor p ON r.codProf = p.codProf");

							if ($query->num_rows() == 0) {
								$this->db->query("INSERT INTO reserva VALUES('{$this->db->escape_str($_POST["fecha"])}', {$this->db->escape_str($_POST['planta'])}, '{$this->db->escape_str($_POST["codAula"])}', '{$this->db->escape_str($_POST["codTramo"])}', {$this->db->escape_str($_GET["codProf"])})");
							} else {
								//Envío el tramo de respuesta. 
								$query = $this->db->query("SELECT r.codProf, TIME_FORMAT(t.horaInicio, '%H:%i') horaInicio, TIME_FORMAT(t.horaFin, '%H:%i') horaFin, p.nombre, p.apellido1 
									FROM tramohorario t JOIN reserva r ON t.codTramo = r.codTramo 
									AND r.planta = {$this->db->escape_str($_POST['planta'])} AND r.codAula = '{$this->db->escape_str($_POST['codAula'])}' AND fecha = '{$this->db->escape_str($_POST["fecha"])}' 
									AND r.codTramo = {$this->db->escape_str($_POST['codTramo'])} 
									JOIN profesor p ON r.codProf = p.codProf");
							}
							
							echo json_encode($query->result(), JSON_NUMERIC_CHECK);
				}
		}

		$this->db->close();
	}

	public function delete($planta, $codAula, $fecha, $codTramo) {
		$this->load->database();

		if (isset($_GET["codProf"]) && isset($_GET["token"])) {
			$query = $this->db->query("SELECT * FROM profesor WHERE codProf = {$this->db->escape_str($_GET['codProf'])} AND token = '{$this->db->escape_str($_GET["token"])}'");
			if ($query->num_rows() > 0) {
				$this->db->query("DELETE FROM reserva WHERE planta = {$this->db->escape_str($planta)} AND codAula = '{$this->db->escape_str($codAula)}' AND fecha = '{$this->db->escape_str($fecha)}' AND codTramo = '{$this->db->escape_str($codTramo)}'");
			}
		}
		
		$this->db->close();
	}
}
