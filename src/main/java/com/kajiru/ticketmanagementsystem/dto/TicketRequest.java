package com.kajiru.ticketmanagementsystem.dto;

import com.kajiru.ticketmanagementsystem.model.TicketPriority;
import com.kajiru.ticketmanagementsystem.model.TicketStatus;
import jakarta.validation.constraints.NotBlank;


public class TicketRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    private TicketStatus status;
    private TicketPriority priority;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public TicketPriority getPriority() {
        return priority;
    }

    public void setPriority(TicketPriority priority) {
        this.priority = priority;
    }
}