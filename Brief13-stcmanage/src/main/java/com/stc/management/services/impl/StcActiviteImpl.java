package com.stc.management.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.stc.management.model.Activite;
import com.stc.management.repository.ActiviteRepository;
import com.stc.management.services.StcServices;

public class StcActiviteImpl implements StcServices<Activite>{
	
	@Autowired
	private ActiviteRepository activiteRepository;

	@Override
	public List<Activite> getall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Activite getById(Long id) { 
		// TODO Auto-generated method stub
		return  null;
	}

	@Override
	public Activite save(Activite type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Long type3, Activite type1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long type) {
		// TODO Auto-generated method stub
		
	}

	
	

}
