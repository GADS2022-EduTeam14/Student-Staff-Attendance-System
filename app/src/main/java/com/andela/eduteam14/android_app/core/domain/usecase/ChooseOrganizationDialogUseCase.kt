package com.andela.eduteam14.android_app.core.domain.usecase

import android.app.AlertDialog
import android.content.Context
import android.widget.Button
import androidx.fragment.app.Fragment
import com.andela.eduteam14.android_app.R
import com.andela.eduteam14.android_app.core.ui.extensions.onClick

class ChooseOrganizationDialogUseCase(
    private val context: Context,
    private val fragment: Fragment,
) {

    operator fun invoke(
        onChooseOrganization: () -> Unit,
        onChooseSchool: () -> Unit,
    ) {
        showDialog(
            onChooseOrganization = {
                onChooseOrganization()
            },
            onChooseSchool = {
                onChooseSchool()
            }
        )
    }

    private fun showDialog(
        onChooseOrganization: () -> Unit,
        onChooseSchool: () -> Unit,
    ) {
        val builder = AlertDialog.Builder(
            context,
            R.style.CustomAlertDialog
        ).create()

        val view =
            fragment.layoutInflater.inflate(R.layout.choose_organization_dialog_layout, null)

        val chooseOrganization =
            view.findViewById<Button>(R.id.ChooseOrganization)

        chooseOrganization.onClick {
            builder.dismiss()
            onChooseOrganization()
        }

        val chooseSchool =
            view.findViewById<Button>(R.id.ChooseSchool)

        chooseSchool.onClick {
            builder.dismiss()
            onChooseSchool()
        }

        builder.setView(view)

        builder.setCanceledOnTouchOutside(true)

        builder.show()
    }
}