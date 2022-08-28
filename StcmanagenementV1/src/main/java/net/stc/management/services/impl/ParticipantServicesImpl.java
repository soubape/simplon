package net.stc.management.services.impl;
import java.util.List;
import net.stc.management.exception.ResourceNotFoundException;
import net.stc.management.model.Participant;
import net.stc.management.repository.ParticipantRepository;
import net.stc.management.services.StcServices;
public class ParticipantServicesImpl implements StcServices<Participant>{

	private ParticipantRepository participantRepository;
	
	public ParticipantServicesImpl(ParticipantRepository participantRepository) {
		super();
		this.participantRepository = participantRepository;
	}

	@Override
	public List<Participant> getAll() {
		return participantRepository.findAll();
	}

	@Override
	public Participant getById(Long id) {
		return participantRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Participant not found" +id) );
	}

	@Override
	public Participant save(Participant participant) {
		return participantRepository.save(participant);
	}

	@Override
	public void update(Participant participant, Long id) {
		Participant participant1 = participantRepository.findById(id).get();
		participant1.setName(participant.getName());
		participant1.setFullname(participant.getFullname());
		participant1.setStructure(participant.getStructure());
		participant1.setTelephone(participant.getTelephone());
		participant1.setResponsable(participant.getResponsable());
		participant1.setActivites(participant.getActivites());
		participantRepository.save(participant);
	}

	@Override
	public void delete(Long id) {
		participantRepository.deleteById(id);
		
	}

	
}
