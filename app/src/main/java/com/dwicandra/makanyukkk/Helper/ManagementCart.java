package com.dwicandra.makanyukkk.Helper;

import android.content.Context;
import android.widget.Toast;

import com.dwicandra.makanyukkk.Domain.FoodDomain;
import com.dwicandra.makanyukkk.Interface.ChangeNumberItemsListener;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertFood(FoodDomain item){
        ArrayList<FoodDomain> foodList = getListCart();
        boolean isExist = false;
        int n = 0;
        for (int i = 0; i < foodList.size(); i++){
            if(foodList.get(i).getTitle().equals(item.getTitle())){
                isExist = true;
                n = i;
                break;
            }
        }if (isExist){
            foodList.get(n).setNumberCardId(item.getNumberCardId());
        }else {
            foodList.add(item);
        }

        tinyDB.putListObject("CartList",foodList);
        Toast.makeText(context,"ADDED TO YOUR CART ",Toast.LENGTH_SHORT).show();
    }

    public ArrayList<FoodDomain> getListCart(){
        return tinyDB.getListObject("CartList");
    }

    public void plusNumberFood(ArrayList<FoodDomain> foodlist, int position, ChangeNumberItemsListener changeNumberItemsListener){
        foodlist.get(position).setNumberCardId(foodlist.get(position).getNumberCardId()+1);
        tinyDB.putListObject("CartList",foodlist);
        changeNumberItemsListener.changed();
    }

    public void minusNumberFood(ArrayList<FoodDomain> foodlist, int position, ChangeNumberItemsListener changeNumberItemsListener){
       if (foodlist.get(position).getNumberCardId() == 1){
           foodlist.remove(position);
       }
       else {
           foodlist.get(position).setNumberCardId(foodlist.get(position).getNumberCardId() - 1);
       }
       tinyDB.putListObject("CartList",foodlist);
       changeNumberItemsListener.changed();
    }

    public Double getTotalFee(){
        ArrayList<FoodDomain> listFood2 = getListCart();
        double fee = 0;
        for(int j = 0; j < listFood2.size(); j++){
            fee = fee + (listFood2.get(j).getprice()*listFood2.get(j).getNumberCardId());
        }
        return fee;
    }
}
