<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class HocsinhModel extends CI_Model {
	public function getAllStudent()
	{
		$this->db->select('*');
		$data = $this->db->get('hocsinh');
		$data = $data->result_array();
		return $data;
	}
	public function addStudent($name,$age,$email)
	{
		$data = array(
			'name' => $name,
			'age' => $age,
			'email' => $email
		);
		$this->db->insert('hocsinh', $data);
		echo json_encode($this->db->insert_id());
	}

	public function getStudentById($id)
	{
		$this->db->select('*');
		$this->db->where('id', $id);
		$data = $this->db->get('hocsinh');
		$data = $data->result_array();
		return $data;
	}

}

/* End of file HocsinhModel.php */
/* Location: ./application/models/HocsinhModel.php */