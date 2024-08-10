# Define the window title you are searching for
$windowTitle = "Legend of Dragoon"

# Find the process with the matching window title
$process = Get-Process | Where-Object { 
    $_.MainWindowTitle -like "*$windowTitle*" 
}

# Check if a process was found
if ($process) {
    # Get the window handle of the process, assuming there is only one match
    $hwnd = $process.MainWindowHandle

    # Handle the case where $hwnd is an array
    if ($hwnd -is [System.Collections.IEnumerable]) {
        $hwnd = $hwnd[0]
    }

    # Convert the window handle to IntPtr directly by casting
    $hwnd = [System.IntPtr]$hwnd

    # Check if the User32 type is already added
    if (-not ([System.Management.Automation.PSTypeName]'User32').Type) {
        # Define the P/Invoke function to call user32.dll methods
        Add-Type @"
        using System;
        using System.Runtime.InteropServices;
        
        public class User32 {
            [DllImport("user32.dll", SetLastError = true)]
            public static extern int GetWindowLong(IntPtr hWnd, int nIndex);

            [DllImport("user32.dll")]
            public static extern int SetWindowLong(IntPtr hWnd, int nIndex, int dwNewLong);

            [DllImport("user32.dll", SetLastError = true)]
            public static extern bool SetWindowPos(IntPtr hWnd, IntPtr hWndInsertAfter, int X, int Y, int cx, int cy, uint uFlags);

            public const int GWL_STYLE = -16;
            public const int WS_BORDER = 0x00800000;
            public const int WS_DLGFRAME = 0x00400000;
            public const int SWP_NOMOVE = 0x0002;
            public const int SWP_NOSIZE = 0x0001;
            public const int SWP_NOZORDER = 0x0004;
            public const int SWP_NOACTIVATE = 0x0010;
            public const int SWP_FRAMECHANGED = 0x0020;
        }
"@
    }

    # Get current window style
    $style = [User32]::GetWindowLong($hwnd, [User32]::GWL_STYLE)

    # Remove the title bar (caption bar) and frame
    $style = $style -band -bnot ([User32]::WS_BORDER -bor [User32]::WS_DLGFRAME)

    # Set the new style
    [User32]::SetWindowLong($hwnd, [User32]::GWL_STYLE, $style)

    # Apply the changes to the window without resizing or moving it
    [User32]::SetWindowPos($hwnd, [IntPtr]::Zero, 0, 0, 0, 0, 
        [User32]::SWP_NOMOVE -bor [User32]::SWP_NOSIZE -bor [User32]::SWP_NOZORDER -bor [User32]::SWP_NOACTIVATE -bor [User32]::SWP_FRAMECHANGED)

    Write-Host "Title bar has been hidden for the window with title '$windowTitle'."
} else {
    Write-Host "No process found with the window title '$windowTitle'."
}
