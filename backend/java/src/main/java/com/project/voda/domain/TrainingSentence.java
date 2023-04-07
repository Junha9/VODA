package com.project.voda.domain;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.project.voda.util.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "training_sentence")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainingSentence extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "training_sentence_idx")
  private Long trainingSentenceIdx;

  @OneToOne(fetch = LAZY)
  @JoinColumn(name = "emotion_idx", nullable = false)
  private Emotion emotion;

  @Column(name = "content", nullable = false)
  private String content;

}
