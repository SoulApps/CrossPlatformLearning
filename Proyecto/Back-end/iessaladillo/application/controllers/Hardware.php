<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Hardware extends CI_Controller {

    public function getAll() {
        $this->load->database();
		
		if (isset($_GET["codProf"]) && isset($_GET["token"])) {
			$query = $this->db->query("SELECT * FROM profesor WHERE codProf = {$this->db->escape_str($_GET['codProf'])} AND token = '{$this->db->escape_str($_GET["token"])}'");
			if ($query->num_rows() > 0) {
				$query = $this->db->query("SELECT * FROM hardware ORDER BY codBarras");
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
				
				$this->db->query("INSERT INTO hardware VALUES('{$this->db->escape_str($obj["codBarras"])}', '{$this->db->escape_str($obj["descripcion"])}', {$this->db->escape_str($obj["unidadesTotales"])}, 0)");
			}
		}
		
		$this->db->close();
	}

    public function put($codBarras) {
		$this->load->database();

		if (isset($_GET["codProf"]) && isset($_GET["token"])) {
			$query = $this->db->query("SELECT * FROM profesor WHERE codProf = {$this->db->escape_str($_GET['codProf'])} AND token = '{$this->db->escape_str($_GET["token"])}'");
			if ($query->num_rows() > 0) {
				$json = file_get_contents('php://input');
				$obj = json_decode($json, true);
				
				$this->db->query("UPDATE hardware SET descripcion = '{$this->db->escape_str($obj["descripcion"])}', unidadesTotales = {$this->db->escape_str($obj["unidadesTotales"])},  unidadesEnUso = {$this->db->escape_str($obj["unidadesEnUso"])} WHERE codBarras = '{$codBarras}'");
			}
		}

		$this->db->close();
	}
}
