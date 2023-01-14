<template>
    <div class="app-container">
      <!-- 输入表单 -->
      <el-form label-width="120px">
        <el-form-item label="讲师名称">
          <el-input v-model="teacher.name" />
        </el-form-item>
        <el-form-item label="入驻时间">
          <el-date-picker v-model="teacher.joinDate" value-format="yyyy-MM-dd" />
        </el-form-item>
        <el-form-item label="讲师排序">
          <el-input-number v-model="teacher.sort" :min="0"/>
        </el-form-item>
        <el-form-item label="讲师头衔">
          <el-select v-model="teacher.level">
            <!--
              数据类型一定要和取出的json中的一致，否则没法回填
              因此，这里value使用动态绑定的值，保证其数据类型是number
              -->
            <el-option :value="1" label="高级讲师"/>
            <el-option :value="0" label="首席讲师"/>
          </el-select>
        </el-form-item>
        <el-form-item label="讲师简介">
          <el-input v-model="teacher.intro"/>
        </el-form-item>
        <el-form-item label="讲师资历">
          <el-input v-model="teacher.career" :rows="10" type="textarea"/>
        </el-form-item>

        <!-- 讲师头像 -->
        <el-form-item label="讲师头像">
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="saveOrUpdate()">保存</el-button>
        </el-form-item>
      </el-form>
    </div>
</template>
<script>
import teacherApi from '@/api/vod/teacher';
import { updateExpression } from '@babel/types';
export default{
    data(){
        return{
            teacher:{
                // 初始值
                sort: 0,
                level: 1
            }
        }
    },
    created(){
        // 修改时获取路径中的id值,根据id查询得到数据
       if(this.$route.params.id){
        const id =this.$route.params.id
        console.log(id)
        this.fetchDataById(id)
       }
    },
    methods:{
        fetchDataById(id){
            teacherApi.getTeacher(id).then(response=>{
                this.teacher=response.data
            })
        },
        save(teacher){
          teacherApi.saveTeacher(teacher)
            .then(response =>{
                // 提示
                this.$message({
                    type: 'success',
                    message: response.message
                });
                this.$router.push({path:'/vod/teacher/list'})
            })
        },
        update(teacher){
          teacherApi.updateTeacher(teacher)
          .then(response=>{
            this.$message({
                    type: 'success',
                    message: response.message
                });
                this.$router.push({path:'/vod/teacher/list'})
          })
        },
      saveOrUpdate(){
          if(!this.teacher.id)
            this.save(this.teacher)
          else
           this.update(this.teacher)
        }

    }
}
</script>
