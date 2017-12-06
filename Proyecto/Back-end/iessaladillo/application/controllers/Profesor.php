<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Profesor extends CI_Controller {

	public function login() {
		$this->load->database();

		$md5 = md5(uniqid(rand(), true));

		$query = $this->db->query("UPDATE profesor SET token = '{$md5}' WHERE email = '{$this->db->escape_str($_POST["email"])}'");
		$query = $this->db->query("SELECT * FROM profesor WHERE email = '{$this->db->escape_str($_POST["email"])}'");
		echo json_encode($query->result(), JSON_NUMERIC_CHECK);

		$this->db->close();
	}

	public function logout($codProf) {
		$this->load->database();
		
		$query = $this->db->query("UPDATE profesor SET token = NULL 
			WHERE codProf = {$this->db->escape_str($codProf)} 
			AND token = '{$this->db->escape_str($_POST["token"])}'");

		$this->db->close();
	}
}
