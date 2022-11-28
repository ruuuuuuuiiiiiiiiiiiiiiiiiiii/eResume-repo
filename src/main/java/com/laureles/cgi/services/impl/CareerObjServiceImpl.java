package com.laureles.cgi.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.laureles.cgi.entity.CareerObj;
import com.laureles.cgi.repository.CareerObjRepository;
import com.laureles.cgi.services.CareerObjService;

@Service
public class CareerObjServiceImpl implements CareerObjService{
	
	private CareerObjRepository careerObjRepository;
	

	public CareerObjServiceImpl(CareerObjRepository careerObjRepository) {
		super();
		this.careerObjRepository = careerObjRepository;
	}

	@Override
	public List<CareerObj> getAllCareerObj() {
		return careerObjRepository.findAll();
	}

	@Override
	public CareerObj getCareerObjById(Long id) {
		return careerObjRepository.findById(id).get();
	}

	@Override
	public CareerObj updateCareerObj(CareerObj CareerObj) {
		return careerObjRepository.save(CareerObj);
	}

	@Override
	public void deleteCareerObjById(Long id) {
		careerObjRepository.deleteById(id);
		
	}

	@Override
	public CareerObj saveCareerObj(CareerObj careerObj) {
		return careerObjRepository.save(careerObj);
	}

}
