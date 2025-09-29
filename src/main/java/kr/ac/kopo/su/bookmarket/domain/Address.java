package kr.ac.kopo.su.bookmarket.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Address
{
    @Id
    @GeneratedValue
    private int id;
    private String country;
    private String zipcode;
    private String addressName; // 기본
    private String detailName; // 상세
}
