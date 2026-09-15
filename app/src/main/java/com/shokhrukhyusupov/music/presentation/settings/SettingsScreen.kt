package com.shokhrukhyusupov.music.presentation.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.automirrored.outlined.VolumeUp
import androidx.compose.material.icons.filled.Devices
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Brush
import androidx.compose.material.icons.outlined.CloudDownload
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Equalizer
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.LockPerson
import androidx.compose.material.icons.outlined.MusicNote
import androidx.compose.material.icons.outlined.NotificationsNone
import androidx.compose.material.icons.outlined.Security
import androidx.compose.material.icons.outlined.Storage
import androidx.compose.material.icons.outlined.Verified
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.shokhrukhyusupov.music.R
import com.shokhrukhyusupov.music.core.ui.theme.dimensions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    state: SettingsUiState,
    onLogoutClick: () -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(text = stringResource(R.string.settings_title)) }
        )

        LazyColumn(
            contentPadding = PaddingValues(MaterialTheme.dimensions.screenPadding),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.paddingMedium),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            item {
                SettingsSection() {
                    SettingsItem(
                        icon = Icons.Outlined.AccountCircle,
                        title = "Аккаунт",
                        subtitle = "shokhrukh@gmail.com",
                        onClick = {}
                    )
                    SettingsDivider()
                    SettingsItem(
                        icon = Icons.Outlined.Verified,
                        title = "Премиум подписка",
                        subtitle = "Активна до 12.12.2026",
                        onClick = {}
                    )
                }
            }

            item {
                SettingsSection() {
                    SettingsItem(
                        icon = Icons.Outlined.Brush,
                        title = "Тема оформления",
                        subtitle = "Системная • Темная / Светлая",
                        onClick = {}
                    )
                    SettingsDivider()
                    SettingsItem(
                        icon = Icons.Outlined.Language,
                        title = "Язык приложения",
                        subtitle = "Русский",
                        onClick = {}
                    )
                }
            }

            item {
                SettingsSection() {
                    SettingsItem(
                        icon = Icons.Outlined.MusicNote,
                        title = "Качество аудио",
                        subtitle = "Высокое (Hi-Fi) • Wi-Fi и сотовая связь",
                        onClick = {}
                    )
                    SettingsDivider()
                    SettingsItem(
                        icon = Icons.AutoMirrored.Outlined.VolumeUp,
                        title = "Эквалайзер и эффекты",
                        subtitle = "Превью • Настройка частот",
                        onClick = {}
                    )
                    SettingsDivider()
                    SettingsItem(
                        icon = Icons.Outlined.Equalizer,
                        title = "Параметры треков",
                        subtitle = "Плавный переход (Crossfade) • Автозапуск",
                        onClick = {}
                    )
                }
            }

            item {
                SettingsSection() {
                    SettingsItem(
                        icon = Icons.Outlined.CloudDownload,
                        title = "Загрузки и офлайн",
                        subtitle = "Качество скачивания • Папка загрузки",
                        onClick = {}
                    )
                    SettingsDivider()
                    SettingsItem(
                        icon = Icons.Outlined.Storage,
                        title = "Использование памяти",
                        subtitle = "Занято 4.2 ГБ из 64 ГБ",
                        onClick = {}
                    )
                    SettingsDivider()
                    SettingsItem(
                        icon = Icons.Outlined.Delete,
                        title = "Очистить кэш",
                        subtitle = "Освободить 1.1 ГБ временных файлов",
                        onClick = {}
                    )
                }
            }

            item {
                SettingsSection() {
                    SettingsItem(
                        icon = Icons.Outlined.LockPerson,
                        title = "Конфиденциальность",
                        subtitle = "Публичные плейлисты • История прослушивания",
                        onClick = {}
                    )
                    SettingsDivider()
                    SettingsItem(
                        icon = Icons.Outlined.Security,
                        title = "Устройства и сессии",
                        subtitle = "Активных сеансов: 3",
                        onClick = {}
                    )
                    SettingsDivider()
                    SettingsItem(
                        icon = Icons.Outlined.NotificationsNone,
                        title = "Уведомления",
                        subtitle = "Push-уведомления • Рассылки",
                        onClick = {}
                    )
                }
            }

            item {
                SettingsSection() {
                    SettingsItem(
                        icon = Icons.Default.Devices,
                        title = "Подключенные устройства",
                        subtitle = "Google Maps • Автомагнитола • Колонки",
                        onClick = {}
                    )
                }
            }

            item {
                SettingsSection() {
                    SettingsItem(
                        icon = Icons.Outlined.Info,
                        title = stringResource(R.string.settings_version_support_title),
                        subtitle = stringResource(
                            id = R.string.settings_version_privacy_subtitle,
                            state.appVersion
                        ),
                        onClick = {}
                    )
                }
            }

            item {
                SettingsSection {
                    SettingsItem(
                        onClick = onLogoutClick,
                        icon = Icons.AutoMirrored.Filled.Logout,
                        title = stringResource(R.string.settings_logout_title),
                        subtitle = stringResource(R.string.settings_logout_subtitle),
                        titleColor = MaterialTheme.colorScheme.error,
                        iconTint = MaterialTheme.colorScheme.error,
                        enabled = !state.isLoading,
                    )
                }
            }
        }
    }
}

@Composable
fun SettingsSection(
    content: @Composable ColumnScope.() -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Card(
            shape = MaterialTheme.shapes.medium,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                content()
            }
        }
    }
}

@Composable
fun SettingsItem(
    onClick: () -> Unit,
    icon: ImageVector,
    title: String,
    subtitle: String,
    titleColor: Color = MaterialTheme.colorScheme.onSurface,
    iconTint: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    enabled: Boolean = true
) {
    val contentAlpha = if (enabled) 1f else 0.38f

    ListItem(
        leadingContent = {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = iconTint.copy(alpha = contentAlpha)
            )
        },
        headlineContent = {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                color = titleColor.copy(alpha = contentAlpha)
            )
        },
        supportingContent = {
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = contentAlpha),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        colors = ListItemDefaults.colors(
            containerColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                onClick = onClick,
                enabled = enabled
            )
    )
}

@Composable
fun SettingsDivider() {
    HorizontalDivider(
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
        thickness = 0.5.dp,
        modifier = Modifier.padding(
            start = MaterialTheme.dimensions.dividerStartInset,
            end = MaterialTheme.dimensions.dividerEndInset
        )
    )
}