<?php
defined('BASEPATH') OR exit('No direct script access allowed');
header('Access-Control-Allow-Origin: *');
header("Access-Control-Allow-Methods: GET, OPTIONS");
class HocSinh extends CI_Controller {

	public function __construct()
	{
		parent::__construct();
		// header('Access-Control-Allow-Origin: *');
		
		$this->load->model('HocsinhModel');
	}

	public function index()
	{
		$data = $this->HocsinhModel->getAllStudent();
		$data['list'] = $data;
		$this->load->view('List_view', $data);
	}

	public function ThemMoi()
	{
		$this->load->view('Add_view');
	}

	public function ThemMoi2()
	{
		$this->load->view('Add2_view');
	}

	public function doAdd()
	{
		$name = $this->input->post('studentName');
		$age = $this->input->post('studentAge');
		$email = $this->input->post('studentEmail');
		
		return $this->HocsinhModel->addStudent($name,$age,$email);
	}

	public function Edit($id)
	{
		$hocsinh = $this->HocsinhModel->getStudentById($id);
		$data['hocsinh'] = $hocsinh;
		$this->load->view('Edit_view', $data);

	}

}

/* End of file HocSinh.php */
/* Location: ./application/controllers/HocSinh.php */