package com.example.supermarket_system.services;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.supermarket_system.dtos.request.PurchaseRequestDto;
import com.example.supermarket_system.dtos.response.PurchaseResponse;
import com.example.supermarket_system.models.Product;
import com.example.supermarket_system.models.promotions.BuyXGetYFreePromotion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;

class PurchaseServiceTest {

    @Mock
    WiremockService wiremockService;

    @InjectMocks
    PurchaseService purchaseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);  // Inicializa os mocks
    }

    @Test
    @DisplayName("Deve fazer uma compra com 2 produtos")
    void testDoPurchase() {
        // Mock do Product que será retornado pelo wiremockService
        Product product1 = new Product("1", "Amazing Pizza", 1099, List.of(new BuyXGetYFreePromotion(2, 1)));
        Product product2 = new Product("2", "Amazing Burger", 999, List.of(new BuyXGetYFreePromotion(2, 1)));

        // Mock da resposta do wiremockService para cada ID de produto
        when(wiremockService.getProductsById("1")).thenReturn(product1);
        when(wiremockService.getProductsById("2")).thenReturn(product2);

        // Criar um PurchaseRequestDto com 2 itens
        PurchaseRequestDto request = new PurchaseRequestDto(
                List.of(
                        new PurchaseRequestDto.ItemBuy("1", 2),  // Compra de 2 "Amazing Pizza"
                        new PurchaseRequestDto.ItemBuy("2", 1)   // Compra de 1 "Amazing Burger"
                )
        );

        // Chamar o método doPurchase
        PurchaseResponse response = purchaseService.doPurchase(request);

        // Verificar se a resposta está correta
        assertNotNull(response);
        assertEquals(2, response.products().size());

        // Verificar se os produtos corretos estão na resposta
        assertEquals("Amazing Pizza", response.products().get(0).name());
        assertEquals(2, response.products().get(0).quantity());

        assertEquals("Amazing Burger", response.products().get(1).name());
        assertEquals(1, response.products().get(1).quantity());
    }
}
