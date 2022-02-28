package com.joaquinemmanuel.mymapsaplication;

import android.content.Context;

import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.ArrayList;

public class MapController {
    Double mapCenterCordinatesLatitud;
    Double mapCenterCordinatesLongitud;
    Context context;
    MapView mapView;
    public MapController(Double mapCenterCordinatesLatitud , double mapCenterCordinatesLongitud , Context context , MapView mapView){
        this.mapView = mapView;
        this.context = context;
        this.mapCenterCordinatesLatitud = mapCenterCordinatesLatitud;
        this.mapCenterCordinatesLongitud = mapCenterCordinatesLongitud;
    }


    public void configurateMap(String title){
        mapView.setTileSource(TileSourceFactory.MAPNIK);
        mapView.getOverlays().add(createOverlays(title));
        GeoPoint point = new GeoPoint(mapCenterCordinatesLatitud , mapCenterCordinatesLongitud);
        mapView.getController().setCenter(point);
        mapView.getController().setZoom(16);
    }

    public ItemizedOverlayWithFocus<OverlayItem> createOverlays(String title){
        GeoPoint point = new GeoPoint(mapCenterCordinatesLatitud , mapCenterCordinatesLongitud);
        OverlayItem overlayItem = new OverlayItem(title ,"Lugar historico" ,point );
        ArrayList<OverlayItem> items = new ArrayList<>();
        items.add(overlayItem);
        ItemizedOverlayWithFocus<OverlayItem> mOverlay = new ItemizedOverlayWithFocus<OverlayItem>(items,
                new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
                    @Override
                    public boolean onItemSingleTapUp(int index, OverlayItem item) {
                        return false;
                    }

                    @Override
                    public boolean onItemLongPress(int index, OverlayItem item) {
                        return false;
                    }
                } , context);
        mOverlay.setFocusItemsOnTap(true);
        return mOverlay;

    }
}
