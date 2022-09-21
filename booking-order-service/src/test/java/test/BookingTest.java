package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.bookingorder.model.BookingOrder;
import com.example.bookingorder.repository.BookingOrderRepository;
import com.example.bookingorder.service.BookingOrderService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { BookingTest .class })

public class BookingTest {
	
	@InjectMocks
	private BookingOrderService bookingOrderService;
	@Mock
	private BookingOrderRepository bookingOrderRepository;
	
	@Test
	public void addOrderTest() {
		ObjectId id3 = new ObjectId("5399aba6e4b0ae375bfdca88");
		BookingOrder booking = new BookingOrder(id3,"12345","pushpak express", 4,"aanchal" ,"mumbai", "kanpur","19-08-2022","xyz@gmail.com");
		when(bookingOrderRepository.save(booking)).thenReturn(booking);
		assertEquals(booking,bookingOrderService.addOrder(booking));	
	}

	
	@Test
	public void getOrderTest() {
		ObjectId id3 = new ObjectId("5399aba6e4b0ae375bfdca88");
		String id=id3.toString();
		Optional<BookingOrder> orderOpt = Optional.of(new BookingOrder(id3,"12345","pushpak express", 4,"aanchal" ,"mumbai", "kanpur","19-08-2022","xyz@gmail.com"));
		when(bookingOrderRepository.findById(id))
		.thenReturn(orderOpt);
		assertEquals(orderOpt, bookingOrderService.getOrder(id));
	}
	

}