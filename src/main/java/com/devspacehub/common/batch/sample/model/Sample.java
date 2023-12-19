/*
 *
 *  © 2023 devspacehub, Inc. All rights reserved.
 *
 *  name : SampleJob
 *  creation : 2023.12.16
 *  author : YoonGiBum
 *
 */

package com.devspacehub.common.batch.sample.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * The type Sample.
 */
@NoArgsConstructor
@Setter
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "sample")
public class Sample {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq", nullable = false)
	private Long seq;

	@Column(name = "contents", length = 1000)
	private String contents;

	@CreatedBy
	@Column(name = "registration_id")
	private String registrationId;

	@CreatedDate
	@Column(name = "registration_datetime")
	private LocalDateTime registrationDateTime;

	@LastModifiedBy
	@Column(name = "update_id")
	private String updateId;

	@LastModifiedDate
	@Column(name = "update_datetime")
	private LocalDateTime updateDateTime;

	/**
	 * Instantiates a new Sample.
	 *
	 * @param contents the contents
	 * @param updateId the update id
	 */
	@Builder
	public Sample(String contents, String updateId) {
		this.contents = contents;
		this.updateId = updateId;
	}
}
