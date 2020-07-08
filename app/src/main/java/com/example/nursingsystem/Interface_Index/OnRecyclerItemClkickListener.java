package com.example.nursingsystem.Interface_Index;

import java.util.List;

public interface OnRecyclerItemClkickListener {
    //RecyclerView的点击事件，将信息回调给view
    void onItemClick(int position, List<String> list);
}
