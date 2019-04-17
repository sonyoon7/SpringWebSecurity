package org.zerock.domain;

import lombok.AllArgsConstructor; // 모든 속성을 사용하는 생성자를 위해
import lombok.Data;
import lombok.NoArgsConstructor; // 비어 있는 생성자를 만들이 위함

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SampleVO {
	 private Integer mno;
	 private String firstName;
	 private String lastName;
	 
}
