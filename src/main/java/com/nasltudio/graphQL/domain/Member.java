package com.nasltudio.graphQL.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Setter
@Getter
@Entity
@Table(name = "member")
@AllArgsConstructor
@NoArgsConstructor
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberSn;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String memberId;

    private String memberEmail;

    private String memberNumber;

}
