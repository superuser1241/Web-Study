package mvc.ajax.service;

import java.util.List;

import mvc.ajax.dao.CustomerDAO;
import mvc.ajax.dao.CustomerDAOImpl;
import mvc.ajax.dto.CustomerDTO;

public class CustomerServiceImpl  implements CustomerService{
   CustomerDAO customerDAO = new CustomerDAOImpl();
   
	@Override
	public boolean idCheck(String id) {
		return customerDAO.idCheck(id);
	}

	@Override
	public int insert(CustomerDTO customerDTO) {
		return customerDAO.insert(customerDTO);
	}

	@Override
	public List<CustomerDTO> selectAll() {
		return customerDAO.selectAll();
	}

	@Override
	public int delete(String id) {
		return customerDAO.delete(id);
	}

	@Override
	public int update(CustomerDTO customerDTO) {
		return customerDAO.update(customerDTO);
	}

}
