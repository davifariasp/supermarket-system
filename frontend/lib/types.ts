export interface Product {
  id: string;
  name: string;
  price: number;
  image: string;
  description: string;
}

export interface CartItem {
  id: string;
  name: string;
  price: number;
  quantity: number;
  image: string;
}

export interface OrderSummary {
  id: string;
  products: {
    id: string;
    name: string;
    quantity: number;
  }[];
  promotions: string[];
  total: number;
  discount: number;
  finalPrice: number;
}