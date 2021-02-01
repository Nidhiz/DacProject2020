/*
 * package com.ohm.controller;
 * 
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.ohm.pojos.Order;
 * 
 * import com.ohm.service.OrderServiceImpl;
 * 
 * @RestController
 * 
 * @RequestMapping("/api/order")
 * 
 * @CrossOrigin public class OrderController {
 * 
 * @Autowired private OrderServiceImpl orderService;
 * 
 * 
 * @PostMapping("") public ResponseEntity<?> addAOrder(@RequestBody Order
 * orders) { return new
 * ResponseEntity<Order>(orderService.saveOrUpdateAOrder(orders),
 * HttpStatus.CREATED); }
 * 
 * @GetMapping("/all") public ResponseEntity<?> listAllOrders() {
 * System.out.println("in list all Orders");
 * 
 * List<Order> details = orderService.findAll();
 * 
 * if (details.isEmpty())
 * 
 * return new ResponseEntity<>(HttpStatus.NO_CONTENT); // in case of non empty
 * list : OK, send the list return new ResponseEntity<>(details, HttpStatus.OK);
 * }
 * 
 * @GetMapping("/all") public Iterable<Order> getAllOrderings(){ return
 * orderService.findAll(); }
 * 
 * @GetMapping("/{OrderId}") public ResponseEntity<Order>
 * getOrderingById(@PathVariable Long orderId) { return new
 * ResponseEntity<Order>(orderService.findByOrderId(orderId), HttpStatus.OK); }
 * }
 */