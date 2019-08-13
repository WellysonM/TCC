<template>
    <v-card
            :style="styles"
            v-bind="$attrs"
            v-on="$listeners"
    >
        <helper-offset
                :full-width="fullWidth"
                :inline="inline"
                :offset="offset"
                v-if="hasOffset"
        >
            <v-card
                    :class="`elevation-${elevation}`"
                    :color="color"
                    class="v-card--material__header"
                    dark
                    v-if="!$slots.offset"
            >
                <slot
                        name="header"
                        v-if="!title && !text"
                />
                <span v-else>
          <h4
                  class="title font-weight-light mb-2"
                  v-text="title"
          />
          <p
                  class="category font-weight-thin"
                  v-text="text"
          />
        </span>
            </v-card>
            <slot
                    name="offset"
                    v-else
            />
        </helper-offset>

        <v-card-text>
            <slot/>
        </v-card-text>

        <v-divider
                class="mx-3"
                v-if="$slots.actions"
        />

        <v-card-actions v-if="$slots.actions">
            <slot name="actions"/>
        </v-card-actions>
    </v-card>
</template>

<script>
    export default {
        inheritAttrs: false,

        props: {
            color: {
                type: String,
                default: 'secondary'
            },
            elevation: {
                type: [Number, String],
                default: 10
            },
            inline: {
                type: Boolean,
                default: false
            },
            fullWidth: {
                type: Boolean,
                default: false
            },
            offset: {
                type: [Number, String],
                default: 24
            },
            title: {
                type: String,
                default: undefined
            },
            text: {
                type: String,
                default: undefined
            }
        },

        computed: {
            hasOffset() {
                return this.$slots.header ||
                    this.$slots.offset ||
                    this.title ||
                    this.text
            },
            styles() {
                if (!this.hasOffset) return null

                return {
                    marginBottom: `${this.offset}px`,
                    marginTop: `${this.offset * 2}px`
                }
            }
        }
    }
</script>

<style lang="scss">
    .v-card--material {
        &__header {
            &.v-card {
                border-radius: 4px;
            }
        }
    }
</style>
