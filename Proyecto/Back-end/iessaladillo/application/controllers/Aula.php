<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Aula extends CI_Controller {

    public function getAll() {
        $this->load->database();
		
		if (isset($_GET["codProf"]) && isset($_GET["token"])) {
			$query = $this->db->query("SELECT * FROM profesor WHERE codProf = {$this->db->escape_str($_GET['codProf'])} AND token = '{$this->db->escape_str($_GET["token"])}'");
			if ($query->num_rows() > 0) {
				$query = $this->db->query("SELECT * FROM aula");
				echo json_encode($query->result(), JSON_NUMERIC_CHECK);
			}
		}

		$this->db->close();
    }
}
