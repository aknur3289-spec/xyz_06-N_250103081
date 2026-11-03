param([ValidateSet('all','test','1','2','3','4','5')][string]$Task = 'all')
$ErrorActionPreference = 'Stop'
Push-Location $PSScriptRoot
try {
    $sources = Get-ChildItem -Path src,test -Recurse -Filter *.java | ForEach-Object FullName
    & javac --release 8 -Xlint:-options -encoding UTF-8 -d bin $sources
    if ($LASTEXITCODE -ne 0) { throw 'Compilation failed' }
    if ($Task -eq 'test') {
        & java '-Duser.language=en' '-Duser.country=US' -cp bin LabTests
        if ($LASTEXITCODE -ne 0) { throw 'Verification failed' }
    } else {
        $numbers = if ($Task -eq 'all') { 1..5 } else { @([int]$Task) }
        foreach ($n in $numbers) {
            & java '-Duser.language=en' '-Duser.country=US' -cp bin "task$n.Task${n}Runner"
            if ($LASTEXITCODE -ne 0) { throw "Task $n failed" }
        }
    }
} finally { Pop-Location }
