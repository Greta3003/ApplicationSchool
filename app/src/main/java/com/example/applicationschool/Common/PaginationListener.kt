package com.example.applicationschool.common

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
// Klasë abstrakte që zgjeron OnScrollListener për të shtuar funksionalitetin e "pagination"
abstract class PaginationListener(private val layoutManager: LinearLayoutManager) : RecyclerView.OnScrollListener() {
    // Kjo metodë abstrakte duhet të implementohet për të ngarkuar më shumë të dhëna
    abstract fun loadMoreItems()
    abstract fun isLastPage(): Boolean // Kjo metodë tregon nëse kemi arritur faqen e fundit
    abstract fun isLoading(): Boolean

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        if (dy <= 0) return // Vetëm scroll poshtë na intereson

        val visibleItemCount = layoutManager.childCount // Numri i artikujve të dukshëm në ekran
        val totalItemCount = layoutManager.itemCount  // Numri total i artikujve në listë
        val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
// Pozicioni i parë i artikullit që shfaqet në ekran
        if (!isLoading() && !isLastPage()) { // Kontrollojmë nëse kemi arritur fundin e listës
            if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                && firstVisibleItemPosition >= 0
            ) {
                loadMoreItems()// therrasim funksionin per te shtuar te dhena
            }
        }
    }
}
