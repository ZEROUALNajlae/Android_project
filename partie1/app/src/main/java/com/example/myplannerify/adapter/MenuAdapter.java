package com.example.myplannerify.adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.myplannerify.R;
import com.example.myplannerify.database_classes.Menu;
import java.io.ByteArrayInputStream;
import java.util.List;

	/**
	 * Created by delaroy on 5/10/17.
	 */
	public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder>  {

		private List<Menu> listMenus;
		private OnClickItemListener mylistener;

		public MenuAdapter(List<Menu> listMenu , OnClickItemListener listener) {
			this.listMenus = listMenu;
			this.mylistener = listener;
		}

		@Override
		public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

			Context context = parent.getContext();
			LayoutInflater inflater = LayoutInflater.from(context);
			View view = inflater.inflate(R.layout.item_menu_recycler , parent, false);

			return new MenuViewHolder(view , mylistener);
		}

		@Override
		public void onBindViewHolder(final MenuViewHolder holder, int position) {
			holder.display(listMenus.get(position));


		}


		@Override
		public int getItemCount() {
			return listMenus.size();
		}


		public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

			public TextView textViewName;
			public TextView textViewEmail;
			public TextView textViewAddress;
			public TextView textViewCountry;
			public  ImageView imageView;
			private OnClickItemListener onClickItemListener;

			public MenuViewHolder(View view , final OnClickItemListener listener) {
				super(view);
				textViewName = (TextView) view.findViewById(R.id.textViewName);
				textViewEmail = (TextView) view.findViewById(R.id.textViewEmail);
				textViewAddress = (TextView) view.findViewById(R.id.textViewAddress);
				textViewCountry = (TextView) view.findViewById(R.id.textViewCountry);
				imageView = (ImageView) view.findViewById(R.id.imageViewName);
				onClickItemListener = listener ;

				itemView.setOnClickListener(this);

			}

			void display(Menu menu ){
				ByteArrayInputStream imageStream = new ByteArrayInputStream(menu.getImage_menu());
				Bitmap theImage = BitmapFactory.decodeStream(imageStream);
				this.imageView.setImageBitmap(theImage);
				this.textViewName.setText(menu.getNom_menu());
				this.textViewEmail.setText(menu.getPrix_menu());
				this.textViewAddress.setText(menu.getDescription_menu());
				this.textViewCountry.setText(Integer.toString(menu.getId_organisateur()));
			}


			@Override
			public void onClick(View v) {
				onClickItemListener.OnClickItem(getAdapterPosition());
			}
		}


		public  interface  OnClickItemListener {
			public void OnClickItem(int position);

		}



	}


