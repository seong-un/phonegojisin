package com.regalaxy.phonesin.rental.model.repository;

import com.regalaxy.phonesin.member.model.SearchDto;
import com.regalaxy.phonesin.rental.model.RentalDetailDto;
import com.regalaxy.phonesin.rental.model.RentalDto;

import java.util.List;

public interface RentalRepositoryCustom {
    List<RentalDto> search(SearchDto searchDto);

    RentalDetailDto detailInfo(int rental_id);
}
