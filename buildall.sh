projects=(
    [0]="http-client"
    [1]="json-parser"
    [2]="core"
)
current=$(pwd)

for i in ${projects[@]}; do
    cd $current
    cd $i
    ant build
done

