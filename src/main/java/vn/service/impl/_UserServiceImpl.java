package vn.service.impl;

import java.util.List;

import vn.dao._UserDAO;
import vn.dao.impl._UserDaoImpl;
import vn.models._User;
import vn.service._UserService;

public class _UserServiceImpl implements _UserService{
	_UserDAO _userDao = new _UserDaoImpl();
	
	@Override
	public List<_User> findAllUser() {
		return _userDao.findAllUser();
	}
	
	@Override
	public _User findUserByID(int _id)
	{
		return _userDao.findUserByID(_id);
	}
	
	@Override
	public void insert(_User user)
	{
		_userDao.insert(user);
	}
	
	@Override
	public void edit(_User user)
	{
		_userDao.edit(user);
	}
	
	@Override
	public void delete(int id)
	{
		_userDao.delete(id);
	}
	
	@Override
	public int[] SignUpInDay(int month, int year) {
		return _userDao.SignUpInDay(month, year);
	}

	@Override
	public int[] SignUpInMonth(int year) {
		return _userDao.SignUpInMonth(year);
	}

	@Override
	public int[] SignUpInYear() {
		return _userDao.SignUpInYear();
	}
	
	@Override
	public int TotalSignUpInDay(int month, int year) {
		return _userDao.TotalSignUpInDay(month, year);
	}
	
	@Override
	public int TotalSignUpInMonth(int year) {
		return _userDao.TotalSignUpInMonth(year);
	}
	
	@Override
	public int TotalSignUpInYear() {
		return _userDao.TotalSignUpInYear();
	}
}
