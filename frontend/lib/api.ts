export async function getProducts() {
  const response = await fetch('http://localhost:8080/products');
  if (!response.ok) {
    throw new Error('Failed to fetch products');
  }
  return response.json();
}

export async function submitOrder(orderData: any) {
  const response = await fetch('http://localhost:8080/purchase', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(orderData),
  });
  
  if (!response.ok) {
    throw new Error('Failed to submit order');
  }
  return response.json();
}