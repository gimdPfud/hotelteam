package com.example.hotelteam.service;

import com.example.hotelteam.dto.StoreDTO;
import com.example.hotelteam.entity.Store;
import com.example.hotelteam.repository.HotelRepository;
import com.example.hotelteam.repository.StoreRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class StoreServiceImpl implements StoreService{
    private final StoreRepository storeRepository;
    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public Long registerStore(StoreDTO storeDTO) {
//        Store store = modelMapper.map(storeDTO, Store.class);
//        store.setHotel(hotelRepository.findById(storeDTO.getHotelNum())
//                .orElseThrow(EntityNotFoundException::new));
        Store store = storeRepository.save(modelMapper.map(storeDTO, Store.class));
        return store.getStoreNum();
    }

    @Override
    public Long modifyStore(StoreDTO storeDTO) {
        //수정 하기 전 수정하려는 대상이 있는지 확인.
        // (안해도 되나?? 이유 : 이미 컨트롤러에서 데이터 가져온걸 고쳐서 넘기는건데??)
        Store store = storeRepository.findById(storeDTO.getStoreNum())
                .orElseThrow(EntityNotFoundException::new);
        if(store!=null){//수정하려는 대상이 있다면
            //저장함. 근데 이미 있는 pk면 알아서 update 해준다 함...
            store = storeRepository.save(modelMapper.map(storeDTO, Store.class));
            return store.getStoreNum();
        }
        else{//수정하려는 대상이 없다면
            return 0L;
        }
    }

    @Override
    public void deleteStore(Long storeNum) {
        storeRepository.deleteById(storeNum);
    }

    @Override
    public StoreDTO detailStore(Long storeNum) {
        Store store = storeRepository.findById(storeNum)
                .orElseThrow(EntityNotFoundException::new);
        StoreDTO storeDTO = modelMapper.map(store, StoreDTO.class);
        return storeDTO;
    }

    @Override
    public List<StoreDTO> listStore(Long hotelNum) {
        List<Store> storeList = storeRepository.findByHotel_HotelNum(hotelNum);
        List<StoreDTO> storeDTOList = new ArrayList<>();
        if(!storeList.isEmpty()){
            for(Store store : storeList){
                StoreDTO storeDTO = modelMapper.map(store, StoreDTO.class);
                storeDTOList.add(storeDTO);
            }
        }
        return storeDTOList;
    }

    @Override
    public List<StoreDTO> listStore(String storeName) {
        List<Store> storeList = storeRepository.findByStoreBrand(storeName);
        List<StoreDTO> storeDTOList = new ArrayList<>();
        if(!storeList.isEmpty()){
            for(Store store : storeList){
                StoreDTO storeDTO = modelMapper.map(store, StoreDTO.class);
                storeDTOList.add(storeDTO);
            }
        }
        return storeDTOList;
    }

    @Override
    public List<StoreDTO> listStore(Long hotelNum, String storeStatus) {
        List<Store> storeList = storeRepository.findByHotel_HotelNumAndStoreStatus(hotelNum, storeStatus);
        List<StoreDTO> storeDTOList = new ArrayList<>();
        if(!storeList.isEmpty()){
            for(Store store : storeList){
                StoreDTO storeDTO = modelMapper.map(store, StoreDTO.class);
                storeDTOList.add(storeDTO);
            }
        }
        return storeDTOList;
    }
}
