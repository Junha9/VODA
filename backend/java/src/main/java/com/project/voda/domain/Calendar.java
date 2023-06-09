package com.project.voda.domain;

import static javax.persistence.FetchType.LAZY;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.project.voda.util.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "calendar")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Calendar extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "calendar_seq")
  private Long calendarSeq;

  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "user_seq", nullable = false)
  private User user;

  @OneToOne(fetch = LAZY)
  @JoinColumn(name = "emotion_idx")
  private Emotion emotion;

  @Column(name = "day", nullable = false)
  private LocalDate day;

  @JsonIgnore
  @OneToMany(mappedBy = "calendar", cascade = CascadeType.REMOVE)
  private List<Diary> diaries = new ArrayList<>();

  public void updateEmotion(Emotion emotion){
    this.emotion = emotion;
  }
}
