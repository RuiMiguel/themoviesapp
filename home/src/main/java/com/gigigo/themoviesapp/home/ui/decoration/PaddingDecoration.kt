package com.gigigo.themoviesapp.home.ui.decoration

import android.content.res.Resources
import android.graphics.Rect
import android.view.View
import androidx.annotation.Dimension
import androidx.annotation.Px
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gigigo.themoviesapp.base.ui.extensions.MetricUtils

open class PaddingDecoration(
    @Px private val start: Int = 0,
    @Px private val internal: Int = 0,
    @Px private val end: Int = 0
) :
    RecyclerView.ItemDecoration() {

    constructor(
        resources: Resources,
        @Dimension(unit = Dimension.DP) startDip: Int = 0,
        @Dimension(unit = Dimension.DP) internalDip: Int = 0,
        @Dimension(unit = Dimension.DP) endDip: Int = 0
    ) : this(
        MetricUtils.dpToPx(resources, startDip)?.toInt() ?: 0,
        MetricUtils.dpToPx(resources, internalDip)?.toInt() ?: 0,
        MetricUtils.dpToPx(resources, endDip)?.toInt() ?: 0
    )

    constructor(
        resources: Resources,
        @Dimension(unit = Dimension.DP) globalDip: Int = 0
    ) : this(
        MetricUtils.dpToPx(resources, globalDip)?.toInt() ?: 0,
        MetricUtils.dpToPx(resources, globalDip)?.toInt() ?: 0,
        MetricUtils.dpToPx(resources, globalDip)?.toInt() ?: 0
    )

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val itemCount = state.itemCount
        val currentPosition = parent.getChildAdapterPosition(view)
        val orientation =
            (parent.layoutManager as? LinearLayoutManager)?.orientation ?: RecyclerView.VERTICAL

        // Calculate start offset
        val start =
            if (currentPosition == 0) {
                start
            } else {
                0
            }

        // Calculate end offset
        val end =
            if (itemCount > 0 && currentPosition == itemCount - 1) {
                end
            } else {
                internal
            }

        when (orientation) {
            RecyclerView.VERTICAL ->
                outRect.set(0, start, 0, end)

            RecyclerView.HORIZONTAL ->
                outRect.set(start, 0, end, 0)
        }
    }
}