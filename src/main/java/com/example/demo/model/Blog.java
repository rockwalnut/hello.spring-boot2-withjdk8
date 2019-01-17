package com.example.demo.model;

import java.io.IOException;
import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

//import com.appman.core.syncservice.dto.EncryptionParams;
//import com.appman.core.syncservice.enumeration.EnumFileStatus;
//import com.appman.core.syncservice.util.JsonUtil;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Blog")
@Table(name = "blog")
@Data
@NoArgsConstructor
public class Blog implements Serializable {
	private static final long serialVersionUID = -7991880517032661710L;

	//@Id
	//@org.hibernate.annotations.Type(type = "pg-uuid")
	//@GeneratedValue(strategy = GenerationType.AUTO, generator = "pg-uuid")
	//@GenericGenerator(name = "pg-uuid", strategy = "uuid2", parameters = @Parameter(name = "uuid_gen_strategy_class", value = "com.appman.core.syncservice.entity.PostgreSQLUUIDGenerationStrategy"))
	//@Column(name = "FileUID")
    //private UUID fileUID;
    
    @Id
    @Column(name = "id")
	private String id;

	@Column(name = "content", length = 64)
	private String content;

	@Column(name = "status")
	private String status; // = EnumFileStatus.AVAILABLE;

	//@Column(name = "StorageType", length = 64)
	//private String storageType;

	/**
	 * columnDefinition = "text" is an alternative way for using @Lob
	 **/
	/*@Column(name = "ReadParams", columnDefinition = "text")
	private String readParams;

	@Column(name = "EncryptionParams", columnDefinition = "text")
	private String encryptionParams;
	*/
	
	@Column(name = "createdby", length = 128)
	private String createdBy;

	@Column(name = "createdat")
	private Long createdAt;

	/*@Column(name = "UpdatedBy", length = 128)
	private String updatedBy;

	@Column(name = "UpdatedAt")
	private Long updatedAt;*/

	/*public EncryptionParams toEncryptionParams() throws IOException {
		return JsonUtil.mapper.readValue(encryptionParams, EncryptionParams.class);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.fileUID).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Attachment) {
			Attachment that = (Attachment) other;
			return new EqualsBuilder().append(this.fileUID, that.fileUID).isEquals();
		} else {
			return false;
		}
	}*/
}
