package com.kajiru.ticketmanagementsystem.service;

import com.kajiru.ticketmanagementsystem.exception.TicketNotFoundException;
import com.kajiru.ticketmanagementsystem.model.Ticket;
import com.kajiru.ticketmanagementsystem.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException(id));
    }

    public Ticket updateTicket(Long id, Ticket ticket) {
        Ticket existingTicket = ticketRepository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException(id));

        existingTicket.setTitle(ticket.getTitle());
        existingTicket.setDescription(ticket.getDescription());
        existingTicket.setStatus(ticket.getStatus());
        existingTicket.setPriority(ticket.getPriority());

        return ticketRepository.save(existingTicket);
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}
