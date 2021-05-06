package com.dicoding.auliarosyida.academy.ui.detail

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dicoding.auliarosyida.academy.R
import com.dicoding.auliarosyida.academy.data.CourseEntity
import com.dicoding.auliarosyida.academy.databinding.ActivityDetailCourseBinding
import com.dicoding.auliarosyida.academy.databinding.ContentDetailCourseBinding
import com.dicoding.auliarosyida.academy.ui.reader.CourseReaderActivity
import com.dicoding.auliarosyida.academy.utils.DataDummy
import com.dicoding.auliarosyida.academy.viewmodel.ViewModelFactory

/**
 * DetailCourseActivity: Menampilkan detail Course dan menampilkan list Module yang ada tiap Course-nya.
 * Selain itu di halaman ini juga nantinya akan ada tombol bookmark untuk menyimpan course yang Anda suka.
 * */
class DetailCourseActivity : AppCompatActivity() {

    private lateinit var detailContentBinding: ContentDetailCourseBinding

    companion object {
        const val EXTRA_COURSE = "extra_course"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val activityDetailCourseBinding = ActivityDetailCourseBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailCourseBinding.detailContent

        setContentView(activityDetailCourseBinding.root)

        setSupportActionBar(activityDetailCourseBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val adapter = DetailCourseAdapter()

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailCourseViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val courseId = extras.getString(EXTRA_COURSE)
            if (courseId != null) {
//                activityDetailCourseBinding.progressBar.visibility = View.VISIBLE
                activityDetailCourseBinding.content.visibility = View.INVISIBLE

                viewModel.setSelectedCourse(courseId) //Dengan bantuan kelas ViewModel, courseId akan dipertahankan sampai Activity masuk ke state onDestroy.
                viewModel.getModules().observe(this, { modules ->
                    activityDetailCourseBinding.progressBar.visibility = View.GONE
                    activityDetailCourseBinding.content.visibility = View.VISIBLE
                    adapter.setModules(modules)
                    adapter.notifyDataSetChanged()
                })
                viewModel.getCourse().observe(this, { course -> populateCourse(course) })
            }
        }

        with(detailContentBinding.rvModule) {
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(this@DetailCourseActivity)
            setHasFixedSize(true)
            this.adapter = adapter
            val dividerItemDecoration = DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
            addItemDecoration(dividerItemDecoration)
        }
    }

    private fun populateCourse(courseEntity: CourseEntity) {
        detailContentBinding.textTitle.text = courseEntity.title
        detailContentBinding.textDescription.text = courseEntity.description
        detailContentBinding.textDate.text = resources.getString(R.string.deadline_date, courseEntity.deadline)

        Glide.with(this)
                .load(courseEntity.imagePath)
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(detailContentBinding.imagePoster)

        detailContentBinding.btnStart.setOnClickListener {
            val intent = Intent(this@DetailCourseActivity, CourseReaderActivity::class.java)
            intent.putExtra(CourseReaderActivity.EXTRA_COURSE_ID, courseEntity.courseId)
            startActivity(intent)
        }
    }
}