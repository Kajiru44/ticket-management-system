package com.kajiru.ticketmanagementsystem.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

import com.kajiru.ticketmanagementsystem.exception.TicketNotFoundException;
import com.kajiru.ticketmanagementsystem.model.Ticket;
import com.kajiru.ticketmanagementsystem.repository.TicketRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class TicketServiceTest {

    @Mock
    private TicketRepository ticketRepository;

    @InjectMocks
    private TicketService ticketService;

    @Test
    void createTicket_shouldSaveTicket() {

        Ticket ticket = new Ticket();
        ticket.setTitle("Test Ticket");
        ticket.setDescription("Test Description");

        when(ticketRepository.save(ticket)).thenReturn(ticket);

        Ticket result = ticketService.createTicket(ticket);

        assertEquals("Test Ticket", result.getTitle());
        assertEquals("Test Description", result.getDescription());
        verify(ticketRepository).save(ticket);
    }

    @Test
    void getTicketById_shouldReturnTicket() {

        Ticket ticket = new Ticket();
        ticket.setTitle("Test Ticket");

        when(ticketRepository.findById(1L))
                .thenReturn(java.util.Optional.of(ticket));

        Ticket result = ticketService.getTicketById(1L);

        assertEquals("Test Ticket", result.getTitle());
    }

    @Test
    void getTicketById_shouldThrowExceptionWhenNotFound() {

        when(ticketRepository.findById(999L))
                .thenReturn(java.util.Optional.empty());

        assertThrows(
                TicketNotFoundException.class,
                () -> ticketService.getTicketById(999L)
        );
    }
}