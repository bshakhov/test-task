package com.flexit.spacetoursinc.booking;

import com.flexit.spacetoursinc.common.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class BookingServiceImpl extends BaseServiceImpl<Booking, BookingVo> implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingConverter bookingConverter;

    public BookingServiceImpl(BookingRepository repository, BookingConverter converter) {
        super(repository, converter);
        this.bookingRepository = repository;
        this.bookingConverter = converter;
    }

    @Override
    public List<BookingVo> findByDepartureDateBetween(Date from, Date to) {
        return bookingConverter.convertEntityToVo(bookingRepository.findByDepartureDateBetween(from, to));
    }
}
