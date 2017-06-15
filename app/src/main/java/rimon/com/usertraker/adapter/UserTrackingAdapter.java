package rimon.com.usertraker.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

import rimon.com.usertraker.R;
import rimon.com.usertraker.model.LocationData;

/**
 *
 */

public class UserTrackingAdapter extends RecyclerView.Adapter<UserTrackingAdapter.UserTrackingViewHolder>{
    private static String TAG=UserTrackingViewHolder.class.getClass().getSimpleName();

    private Activity mActivity;
    private List<LocationData> mLocationList;

    public UserTrackingAdapter(Activity mActivity, List<LocationData> mLocationList) {
        this.mActivity = mActivity;
        this.mLocationList = mLocationList;
    }

    @Override
    public UserTrackingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View flatItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_location_tracking_item, parent, false);
        return new UserTrackingViewHolder(flatItem);
    }

    @Override
    public void onBindViewHolder(UserTrackingViewHolder holder, int position) {
        final LocationData location=mLocationList.get(position);
        String latitude = location.getLatitude();
        String longitude = location.getLongitude();
        String date = location.getTime();
        holder.txtLatitude.setText(latitude);
        holder.txtLongitude.setText(longitude);
        holder.txtDateTime.setText(date);
        ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) holder.itemView.getLayoutParams();
        int _04 = (int) mActivity.getResources().getDimension(R.dimen.item_padding);
        if (mLocationList.size() == (position + 1)) {
            mlp.setMargins(_04, _04, _04, (int) mActivity.getResources().getDimension(R.dimen.item_bottom));
        } else {
            mlp.setMargins(_04, _04, _04, 0);
        }
    }

    @Override
    public int getItemCount() {
        return (null != mLocationList ? mLocationList.size() : 0);
    }

    class UserTrackingViewHolder extends RecyclerView.ViewHolder {
        TextView txtLatitude,txtLongitude,txtDateTime;
        UserTrackingViewHolder(View itemView) {
            super(itemView);
            txtLatitude=(TextView) itemView.findViewById(R.id.txtLatitude);
            txtLongitude = (TextView) itemView.findViewById(R.id.txtLongitude);
            txtDateTime = (TextView) itemView.findViewById(R.id.txtDateTime);
        }
    }
}
