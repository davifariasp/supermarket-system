'use client';

import { OrderSummary as OrderSummaryType } from '@/lib/types';
import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
} from '@/components/ui/dialog';
import { Button } from '@/components/ui/button';

interface OrderSummaryProps {
  order: OrderSummaryType | null;
  isOpen: boolean;
  onClose: () => void;
}

export function OrderSummary({ order, isOpen, onClose }: OrderSummaryProps) {
  if (!order) return null;

  return (
    <Dialog open={isOpen} onOpenChange={onClose}>
      <DialogContent>
        <DialogHeader>
          <DialogTitle>Order Summary</DialogTitle>
        </DialogHeader>
        <div className="mt-4 space-y-4">
          <div className="space-y-2">
            <h4 className="font-medium">Products:</h4>
            {order.products.map((product) => (
              <div key={product.id} className="flex justify-between text-sm">
                <span>{product.name}</span>
                <span>x{product.quantity}</span>
              </div>
            ))}
          </div>
          {order.promotions.length > 0 && (
            <div className="space-y-2">
              <h4 className="font-medium">Applied Promotions:</h4>
              {order.promotions.map((promotion) => (
                <div key={promotion} className="text-sm">
                  {promotion}
                </div>
              ))}
            </div>
          )}
          <div className="space-y-2 pt-4 border-t">
            <div className="flex justify-between">
              <span>Subtotal:</span>
              <span>${(order.total / 100).toFixed(2)}</span>
            </div>
            <div className="flex justify-between text-green-600">
              <span>Discount:</span>
              <span>-${(order.discount / 100).toFixed(2)}</span>
            </div>
            <div className="flex justify-between font-bold text-lg">
              <span>Final Price:</span>
              <span>${(order.finalPrice / 100).toFixed(2)}</span>
            </div>
          </div>
          <Button className="w-full" onClick={onClose}>
            Close
          </Button>
        </div>
      </DialogContent>
    </Dialog>
  );
}