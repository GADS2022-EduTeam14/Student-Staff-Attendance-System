package com.andela.eduteam14.android_app.core.domain.usecase

import android.app.AlertDialog
import android.content.Context
import android.widget.Button
import androidx.fragment.app.Fragment
import com.andela.eduteam14.android_app.R
import com.andela.eduteam14.android_app.core.ui.extensions.onClick


class ChooseMemberDialogUseCase(
    private val context: Context,
    private val fragment: Fragment,
) {

    operator fun invoke(
        onChooseStaff: () -> Unit,
        onChooseStudent: () -> Unit,
    ) {
        showDialog(
            onChooseStaff = {
                onChooseStaff()
            },
            onChooseStudent = {
                onChooseStudent()
            }
        )
    }

    private fun showDialog(
        onChooseStaff: () -> Unit,
        onChooseStudent: () -> Unit,
    ) {
        val builder = AlertDialog.Builder(
            context,
            R.style.CustomAlertDialog
        ).create()

        val view =
            fragment.layoutInflater.inflate(R.layout.choose_member_dialog_layout, null)

        val chooseStaff =
            view.findViewById<Button>(R.id.ChooseStaff)

        chooseStaff.onClick {
            builder.dismiss()
            onChooseStaff()
        }

        val chooseStudent =
            view.findViewById<Button>(R.id.ChooseStudent)

        chooseStudent.onClick {
            builder.dismiss()
            onChooseStudent()
        }

        builder.setView(view)

        builder.setCanceledOnTouchOutside(true)

        builder.show()
    }
}