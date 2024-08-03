package com.wcg.wcg.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Table(name = "races")
@Entity
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class RaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private UUID id;
    @Column
    private String name;
    @ManyToMany
    private List<SkillEntity> defaultSkills;
    @ManyToMany
    private List<TalentEntity> defaultTalents;
}
