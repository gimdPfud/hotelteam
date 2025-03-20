package com.example.hotelteam.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class StoreDTO {
    private Long storeNum;/*pk*/

    @Size(min = 1)
    private String storeStatus;/*가맹점인지 직영점인지?*/

    @Size(min = 1)
    private String storeBrand;/*가게 이름*/
    @Size(min = 1)
    private String storeName;/*가게 이름*/

    @Size(min = 1)
    private String storeManagerName;/*가게 담당자 이름 : 가맹이면 사장, 직영이면 담당자..*/

    @Size(min = 1)
    private String storeManagerContact;/*가게 담당자 연락처*/

    private Long hotelNum;/*FK : 호텔의 pk*/
}
