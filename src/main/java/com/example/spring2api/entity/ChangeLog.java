package com.example.spring2api.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Entity
@Table(name = "changelog")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChangeLog {
    @Id
    @GeneratedValue
    private UUID id;
    @Lob
    private String data;
}
