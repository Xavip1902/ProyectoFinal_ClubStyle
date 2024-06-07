package com.example.proyectofinal_clubstyle;

import android.content.Context;
import android.widget.Toast;

import com.example.project1861.Domain.ItemsDomain;
import com.example.proyectofinal_clubstyle.dominio.ItemDominio;

import java.util.ArrayList;

public class ManagmentCart {

    private Context context;
    private TinyDB tinyDB;

    public ManagmentCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertarItem(ItemDominio item) {
        ArrayList<ItemDominio> listItem = getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int y = 0; y < listItem.size(); y++) {
            if (listItem.get(y).getTitulo().equals(item.getTitulo())) {
                existAlready = true;
                n = y;
                break;
            }
        }
        if (existAlready) {
            listItem.get(n).setNumeroEnCarrito(item.getNumeroEnCarrito());
        } else {
            listItem.add(item);
        }
        tinyDB.putListObject("Carrito", listItem);
        Toast.makeText(context, "Añadir al carrito", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<ItemDominio> getListaCar() {
        return tinyDB.getListObject("Lista");
    }

    public void minusItem(ArrayList<ItemDominio> listItem, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        if (listItem.get(position).getNumeroEnCarrito() == 1) {
            listItem.remove(position);
        } else {
            listItem.get(position).setNumeroEnCarrito(listItem.get(position).getNumeroEnCarrito() - 1);
        }
        tinyDB.putListObject("Lista", listItem);
        changeNumberItemsListener.changed();
    }

    public void plusItem(ArrayList<ItemDominio> listItem, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        listItem.get(position).setNumeroEnCarrito(listItem.get(position).getNumeroEnCarrito() + 1);
        tinyDB.putListObject("CartList", listItem);
        changeNumberItemsListener.changed();
    }

    public Double getTotalFee() {
        ArrayList<ItemDominio> listItem2 = getListaCar();
        double fee = 0;
        for (int i = 0; i < listItem2.size(); i++) {
            fee = fee + (listItem2.get(i).getPrecio() * listItem2.get(i).getNumeroEnCarrito());
        }
        return fee;
    }
}
