package com.saico.cvportfolio.home.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.saico.cvportfolio.home.HomeViewModel
import com.saico.cvportfolio.theme.FontSizes
import com.saico.cvportfolio.theme.PaddingDim
import com.saico.cvportfolio.ui.R
import com.saico.cvportfolio.ui.component.CVPCard
import com.saico.cvportfolio.ui.component.CVPText
import com.saico.cvportfolio.ui.component.CVPTextArea
import com.saico.cvportfolio.ui.component.CVPTextButtonBorder
import com.saico.cvportfolio.ui.component.CVPTextField
import com.saico.cvportfolio.util.reDirect
import com.saico.cvportfolio.util.sendEmail

@Composable
fun MainContactScreen(
    modifier: Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ContactContent(
        onSubjectChanged = viewModel::onSubjectChanged,
        onContentChanged = viewModel::onContentChanged,
        subject = uiState.subject,
        content = uiState.content
    )
}

@Composable
fun ContactContent(
    onSubjectChanged: (String) -> Unit,
    onContentChanged: (String) -> Unit,
    subject: String,
    content: String
) {

    val context = LocalContext.current


    val lin = "https://www.linkedin.com/in/jorge-adrián-valdés-camacho-21b371221"
    val git = "https://github.com/saicojavc"

    LazyColumn(
        modifier = Modifier.padding(bottom = PaddingDim.GIGANT),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Column(
                modifier = Modifier
                    .padding(PaddingDim.LARGE)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                Image(
                    painter = painterResource(id = R.drawable.undraw_personal_email_re_4lx7),
                    contentDescription = "",
                    modifier = Modifier
                        .height(200.dp)
                        .width(220.dp)
                        .clip(shape = RoundedCornerShape(PaddingDim.VERY_LARGE))
                )

                CVPText(
                    modifier = Modifier.padding(PaddingDim.MEDIUM),
                    text = stringResource(id = R.string.contact_me),
                    fontSize = FontSizes.TITLE_BIG,
                    fontWeight = FontWeight.Bold
                )
            }


            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                CVPTextField(
                    colors = TextFieldColors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black, // Igual que focusedTextColor
                        disabledTextColor = Color.LightGray,
                        errorTextColor = Color.Red,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White, // Igual que focusedContainerColor
                        disabledContainerColor = Color.LightGray,
                        errorContainerColor = Color(0xFFFFE0E0), // Light red for error background
                        cursorColor = Color(0xFF2DE82D),
                        errorCursorColor = Color.Red,
                        textSelectionColors = TextSelectionColors(
                            handleColor = Color(0xFF2DE82D),
                            backgroundColor = Color(0xFFB3D4FC) // Light blue selection background
                        ),
                        focusedIndicatorColor = Color(0xFF2DE82D),
                        unfocusedIndicatorColor = Color(0xFF2DE82D), // Igual que focusedIndicatorColor
                        disabledIndicatorColor = Color.LightGray,
                        errorIndicatorColor = Color.Red,
                        focusedLeadingIconColor = Color(0xFF2DE82D),
                        unfocusedLeadingIconColor = Color(0xFF2DE82D), // Igual que focusedLeadingIconColor
                        disabledLeadingIconColor = Color.LightGray,
                        errorLeadingIconColor = Color.Red,
                        focusedTrailingIconColor = Color(0xFF2DE82D),
                        unfocusedTrailingIconColor = Color(0xFF2DE82D), // Igual que focusedTrailingIconColor
                        disabledTrailingIconColor = Color.LightGray,
                        errorTrailingIconColor = Color.Red,
                        focusedLabelColor = Color.Black,
                        unfocusedLabelColor = Color.Black, // Igual que focusedLabelColor
                        disabledLabelColor = Color.LightGray,
                        errorLabelColor = Color.Red,
                        focusedPlaceholderColor = Color.Gray.copy(alpha = 0.5f),
                        unfocusedPlaceholderColor = Color.Gray.copy(alpha = 0.5f), // Igual que focusedPlaceholderColor
                        disabledPlaceholderColor = Color.LightGray.copy(alpha = 0.5f),
                        errorPlaceholderColor = Color.Red.copy(alpha = 0.5f),
                        focusedSupportingTextColor = Color.Black,
                        unfocusedSupportingTextColor = Color.Black, // Igual que focusedSupportingTextColor
                        disabledSupportingTextColor = Color.LightGray,
                        errorSupportingTextColor = Color.Red,
                        focusedPrefixColor = Color.Black,
                        unfocusedPrefixColor = Color.Black, // Igual que focusedPrefixColor
                        disabledPrefixColor = Color.LightGray,
                        errorPrefixColor = Color.Red,
                        focusedSuffixColor = Color.Black,
                        unfocusedSuffixColor = Color.Black, // Igual que focusedSuffixColor
                        disabledSuffixColor = Color.LightGray,
                        errorSuffixColor = Color.Red
                    ),
                    label = stringResource(id = R.string.subject),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.padding(PaddingDim.SMALL),
                    onValueChange = { onSubjectChanged(it) },
                    value = subject
                )

                CVPTextArea(
                    colors = TextFieldColors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black, // Igual que focusedTextColor
                        disabledTextColor = Color.LightGray,
                        errorTextColor = Color.Red,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White, // Igual que focusedContainerColor
                        disabledContainerColor = Color.LightGray,
                        errorContainerColor = Color(0xFFFFE0E0), // Light red for error background
                        cursorColor = Color(0xFF2DE82D),
                        errorCursorColor = Color.Red,
                        textSelectionColors = TextSelectionColors(
                            handleColor = Color(0xFF2DE82D),
                            backgroundColor = Color(0xFFB3D4FC) // Light blue selection background
                        ),
                        focusedIndicatorColor = Color(0xFF2DE82D),
                        unfocusedIndicatorColor = Color(0xFF2DE82D), // Igual que focusedIndicatorColor
                        disabledIndicatorColor = Color.LightGray,
                        errorIndicatorColor = Color.Red,
                        focusedLeadingIconColor = Color(0xFF2DE82D),
                        unfocusedLeadingIconColor = Color(0xFF2DE82D), // Igual que focusedLeadingIconColor
                        disabledLeadingIconColor = Color.LightGray,
                        errorLeadingIconColor = Color.Red,
                        focusedTrailingIconColor = Color(0xFF2DE82D),
                        unfocusedTrailingIconColor = Color(0xFF2DE82D), // Igual que focusedTrailingIconColor
                        disabledTrailingIconColor = Color.LightGray,
                        errorTrailingIconColor = Color.Red,
                        focusedLabelColor = Color.Black,
                        unfocusedLabelColor = Color.Black, // Igual que focusedLabelColor
                        disabledLabelColor = Color.LightGray,
                        errorLabelColor = Color.Red,
                        focusedPlaceholderColor = Color.Gray.copy(alpha = 0.5f),
                        unfocusedPlaceholderColor = Color.Gray.copy(alpha = 0.5f), // Igual que focusedPlaceholderColor
                        disabledPlaceholderColor = Color.LightGray.copy(alpha = 0.5f),
                        errorPlaceholderColor = Color.Red.copy(alpha = 0.5f),
                        focusedSupportingTextColor = Color.Black,
                        unfocusedSupportingTextColor = Color.Black, // Igual que focusedSupportingTextColor
                        disabledSupportingTextColor = Color.LightGray,
                        errorSupportingTextColor = Color.Red,
                        focusedPrefixColor = Color.Black,
                        unfocusedPrefixColor = Color.Black, // Igual que focusedPrefixColor
                        disabledPrefixColor = Color.LightGray,
                        errorPrefixColor = Color.Red,
                        focusedSuffixColor = Color.Black,
                        unfocusedSuffixColor = Color.Black, // Igual que focusedSuffixColor
                        disabledSuffixColor = Color.LightGray,
                        errorSuffixColor = Color.Red
                    ),
                    label = stringResource(id = R.string.content),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.padding(PaddingDim.SMALL),
                    onValueChange = { onContentChanged(it) },
                    value = content
                )
                Spacer(modifier = Modifier.height(PaddingDim.SMALL))

                CVPTextButtonBorder(
                    modifier = Modifier
                        .padding(PaddingDim.SMALL)
                        .fillMaxWidth(),
                    onClick = {
                        context.sendEmail(subject = subject, message = content)
                    },
                    content = {
                        Image(
                            painter = painterResource(id = R.drawable.email),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(horizontal = PaddingDim.MEDIUM)
                                .clip(shape = RoundedCornerShape(PaddingDim.VERY_LARGE))
                        )
                        CVPText(
                            text = stringResource(id = R.string.send_mail)
                        )
                    }
                )
            }
            Spacer(modifier = Modifier.height(PaddingDim.SMALL))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                CVPText(
                    modifier = Modifier.padding(PaddingDim.MEDIUM),
                    text = stringResource(id = R.string.search_me),
                    fontSize = FontSizes.TITLE_BIG,
                    fontWeight = FontWeight.Bold
                )
            }


            CVPCard(
                modifier = Modifier
                    .padding(
                        start = PaddingDim.SMALL,
                        end = PaddingDim.SMALL,
                        top = PaddingDim.MEDIUM,
                        bottom = PaddingDim.MEDIUM
                        )
            ) {
                Row(
                    modifier = Modifier
                        .padding(PaddingDim.SMALL)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center

                ) {

                    Image(
                        painter = painterResource(id = R.drawable.lin),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(100.dp)
                            .height(50.dp)
                            .padding(horizontal = PaddingDim.VERY_LARGE)
                            .clip(shape = RoundedCornerShape(PaddingDim.VERY_LARGE))
                            .clickable {
                                context.reDirect(lin)

                            }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.github),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(100.dp)
                            .height(50.dp)
                            .padding(horizontal = PaddingDim.VERY_LARGE)
                            .clip(shape = RoundedCornerShape(PaddingDim.VERY_LARGE))
                            .clickable {
                                context.reDirect(git)

                            }
                    )
                }
            }
        }
    }
//    Column(
//        modifier = Modifier.padding(PaddingDim.SMALL),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//
//    }
}
