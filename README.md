<p align="center">
  <a href="#technologies">Technologies</a>
  &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#follow-up-questions">Questions</a>
</p>

## Interface

<div align="center">
    <img alt="Our products" src="https://i.imgur.com/e2a9Ptu.png" width="400" />
    <img alt="Cart" src="https://i.imgur.com/hqB3VOk.png" width="400" />
    <img alt="Order sumary" src="https://i.imgur.com/NVbds2B.png" width="400" />
</div>

## Technologies
- Java 23
- Spring Web
- Spring Tests
- Jackson JSON
- Mockito
- Swagger
- Lombok
- NextJS
- Tailwhind

## Follow up questions

<h3> 1. How long did you spend on the test? What would you add if you had more time? </h1>
<p>
I’m not sure exactly, but it took me between 3 and 4 days. I worked on the test during my spare time. I believe i could have added more tests, but i chose to simplify.
</p>


<h3> 2. What was the most useful feature that was added to the latest version of your chosen language? Please include a snippet of code that
shows how you've used it.</h3>

<p>
In building the API, i used two recent features of Java 23: Records (which were used in the DTOs) and instanceof, a method used to check if one class belongs to another.

Example of DTO using Record:
```
public record PurchaseRequestDto(
        List<ItemBuy> items
) {
    public record ItemBuy(
            String id,
            int quantity
    ){}
}
```

Example of instanceof:
```
if(promotion instanceof QuantityBasedPriceOverridePromotion qtyPromotion){
    int xApply = purchaseItem.getQuantity() / qtyPromotion.getRequiredQuantity();
    int descontoTotal = xApply * qtyPromotion.getPrice();

    setDiscount(descontoTotal);
}
```
</p>

<h3>3. What did you find most difficult?</h3>

<p>The issue of promotions and how to apply them. It’s a practical logic challenge, and it took me some time to solve.</p>

<h3> 4. What mechanism did you put in place to track down issues in production on this code? If you didn’t put anything, write down what you
could do. </h3>

<p>I didn't implement any mechanism to track issues or errors in production, but in this case, problems related to Spring Web are already handled and return errors via HTTP status. I also implemented RuntimeExceptions with class APIException for runtime errors in the code. On the front end, I also implemented alerts for when it's not possible to perform an action via the API (such as retrieving or sending data, for example).</p>

<h3> 5. Explain your interpretation of the list of requirements and what was delivered or not delivered and why. </h3>

<p>From what I understand, the system is meant to work in a microservices architecture, with Wiremock being used for the microservice responsible for products and the microservice i created being responsible for purchases.

I was able to deliver all the requirements and even added a Next.js interface to consumer the application. I also added Swagger to the API for documentation purposes.

I could have also saved the purchases in a database, created a service to store the user, and built an end-to-end system. However, I believe the goal of the challenge was to build a module of an application, and for that purpose, I think the challenge was completed successfully.</p>