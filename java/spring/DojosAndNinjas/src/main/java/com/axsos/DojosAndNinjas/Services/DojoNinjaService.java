package com.axsos.DojosAndNinjas.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.DojosAndNinjas.models.Dojo;
import com.axsos.DojosAndNinjas.models.Ninja;
import com.axsos.DojosAndNinjas.repositories.DojoRepository;
import com.axsos.DojosAndNinjas.repositories.NinjaRepository;

@Service
public class DojoNinjaService {
private final DojoRepository dojoRepository;
private final NinjaRepository ninjaRepository;
public DojoNinjaService(DojoRepository dojoRepository, NinjaRepository ninjaRepository) {
	this.dojoRepository = dojoRepository;
	this.ninjaRepository = ninjaRepository;
}

public Dojo findDojo(long id) {
	Dojo dojo = dojoRepository.findById(id).orElse(null);
	System.out.println(dojo.getName());
	return dojo;
}

public Dojo creatDojo(Dojo b) {
	return dojoRepository.save(b);
}
public Ninja createNinja(Ninja a) {
	return ninjaRepository.save(a);
}

public Optional<Ninja> findNinja(long id) {
	return ninjaRepository.findById(id);
}
public List<Dojo> findAllDojos(){
	return dojoRepository.findAll();
}
}
